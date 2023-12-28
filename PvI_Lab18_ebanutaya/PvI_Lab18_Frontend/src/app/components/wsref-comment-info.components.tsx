import { useState } from 'react';
import { Roles } from '../utils/roles';
import { WsrefCommentFormComponent } from './wsref-comment-form.component';

export function WsrefCommentInfoComponent({ role, wsrefComment, updateWsrefComment, deleteWsrefComment, }: {
  role: Roles;
  wsrefComment: any;
  updateWsrefComment: (id: number, wsrefCommentDto: any) => Promise<any>;
  deleteWsrefComment: (id: number) => Promise<any>;
}) {
  let [updating, setUpdating] = useState(false);
  let [deleting, setDeleting] = useState(false);
  let stamp = new Date(wsrefComment.stamp);

  return (
    <fieldset className="bg-gray-800 p-4 rounded my-4">
      <legend className="text-white">
        {stamp.getFullYear()}-{stamp.getMonth() + 1}-{stamp.getDate()}{' '}
        {stamp.getHours()}:{stamp.getMinutes()}:{stamp.getSeconds()}
      </legend>
      {!updating && !deleting ? (
        <>
          {role === Roles.ADMIN ||
          sessionStorage.getItem('sessionId') === wsrefComment.sessionId ? (
            <div className="flex my-2">
              <button className="bg-red-500 text-white px-2 py-1 rounded mr-2" onClick={(e: any) => setDeleting(true)} > Delete </button>
              <button className="bg-blue-500 text-white px-2 py-1 rounded" onClick={(e: any) => setUpdating(true)} > Update </button>
            </div>
          ) : null}
          <div className="flex mb-4">
            <textarea
              className="w-full p-2 border rounded bg-gray-700 text-white"
              readOnly={true}
              value={wsrefComment.comtext}
            />
          </div>
        </>
      ) : null}
      {updating ? (
        <WsrefCommentFormComponent
          wsrefComment={wsrefComment}
          updateWsrefComment={async (wsrefCommentDto: any) => {
            await updateWsrefComment(wsrefComment.id, wsrefCommentDto);
            setUpdating(false);
          }}
          onClose={() => setUpdating(false)}
        />
      ) : null}
      {deleting ? (
        <div className="bg-gray-700 p-4 rounded my-4">
          <div className="text-white mb-4">Delete</div>
          <div className="flex mb-4">
            <textarea
              readOnly={true}
              className="w-full p-2 border rounded bg-gray-600 text-white"
            >
              {wsrefComment.comtext}
            </textarea>
          </div>
          <div className="flex justify-end">
            <button
              className="bg-red-500 text-white px-4 py-2 rounded mr-2"
              onClick={async (e: any) => {
                await deleteWsrefComment(wsrefComment.id);
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
    </fieldset>
  );
}
