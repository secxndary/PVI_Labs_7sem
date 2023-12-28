import { useState } from 'react';
import { WsrefFormComponent } from './wsref-form.component';
import { Roles } from '../utils/roles';
import { WsrefCommentListComponent } from './wsref-comment-list.component';

export function WsrefInfoComponent({ role, wsref, updateWsref, deleteWsref, incrementWsref, decrementWsref, }: {
  role: Roles;
  wsref: any;
  updateWsref: (id: number, wsrefDto: any) => Promise<any>;
  deleteWsref: (id: number) => Promise<any>;
  incrementWsref: (id: number) => Promise<any>;
  decrementWsref: (id: number) => Promise<any>;
}) {
  let [updating, setUpdating] = useState(false);
  let [deleting, setDeleting] = useState(false);
  let [comments, setComments] = useState(false);

  return (
    <div className="bg-gray-800 p-4 rounded my-4">
      {role === Roles.ADMIN ? (
        <div className="mb-4">
          <button
            className="bg-red-500 text-white px-4 py-2 rounded mr-2"
            onClick={(e: any) => setDeleting(true)}
          >
            Delete
          </button>
          <button
            className="bg-blue-500 text-white px-4 py-2 rounded"
            onClick={(e: any) => setUpdating(true)}
          >
            Update
          </button>
        </div>
      ) : null}
      <div className="mb-4">
        <button
          className="bg-green-500 text-white px-4 py-2 rounded mr-2"
          onClick={(e: any) => incrementWsref(wsref.id)}
        >
          +{wsref.plus}
        </button>
        <button
          className="bg-red-500 text-white px-4 py-2 rounded mr-2"
          onClick={(e: any) => decrementWsref(wsref.id)}
        >
          -{wsref.minus}
        </button>
        <button
          className="bg-gray-500 text-white px-4 py-2 rounded"
          onClick={(e: any) => setComments(!comments)}
        >
          Comments
        </button>
      </div>
      <div className="mb-4">
        [{wsref.id}]
        <a href={wsref.url} className="text-blue-500">
          {wsref.description.toUpperCase()}
        </a>
      </div>
      {updating ? (
        <div className="mb-4">
          <WsrefFormComponent
            wsref={wsref}
            updateWsref={async (wsrefDto: any) => {
              await updateWsref(wsref.id, wsrefDto);
              setUpdating(false);
            }}
            onClose={() => setUpdating(false)}
          />
        </div>
      ) : null}
      {deleting ? (
        <div className="mb-4">
          <div className="text-white">{wsref.id}</div>
          <div className="text-white">{wsref.description.toUpperCase()}</div>
          <div className="flex justify-end">
            <button
              className="bg-red-500 text-white px-4 py-2 rounded mr-2"
              onClick={async (e: any) => {
                await deleteWsref(wsref.id);
                setDeleting(false);
              }}
            >
              OK
            </button>
            <button
              className="bg-gray-500 text-white px-4 py-2 rounded"
              onClick={(e: any) => setDeleting(false)}
            >
              Cancel
            </button>
          </div>
        </div>
      ) : null}
      {comments ? (
        <div className="mb-4">
          <WsrefCommentListComponent role={role} wsref={wsref} />
        </div>
      ) : null}
    </div>
  );
}
