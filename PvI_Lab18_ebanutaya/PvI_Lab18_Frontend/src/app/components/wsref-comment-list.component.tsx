import { useEffect, useState } from 'react';
import { Roles } from '../utils/roles';
import { Api } from '../utils/api';
import { WsrefCommentFormComponent } from './wsref-comment-form.component';
import { WsrefCommentInfoComponent } from './wsref-comment-info.components';

export function WsrefCommentListComponent({ role, wsref, }: {
  role: Roles;
  wsref: any;
}) {
  let [wsrefCommentList, setWsrefCommentList] = useState<any[]>();
  let [inserting, setInserting] = useState(false);

  const api = Api.getInstance();

  const loadWsrefComments = async () => {
    let wsrefCommentsData = await api.get(`/wsrefcomment`, { wsref: wsref.id, });
    if (wsrefCommentsData!) setWsrefCommentList(wsrefCommentsData);
  };

  const insertWsrefComment = async (wsrefCommentDto: any) => {
    await api.post(`/wsrefcomment`, wsrefCommentDto);
    loadWsrefComments();
  };

  const updateWsrefComment = async (id: number, wsrefCommentDto: any) => {
    await api.put(`/wsrefcomment/${id}`, wsrefCommentDto);
    loadWsrefComments();
  };

  const deleteWsrefComment = async (id: number) => {
    await api.delete(`/wsrefcomment/${id}`);
    loadWsrefComments();
  };

  useEffect(() => {
    loadWsrefComments();
  }, []);

  return (
    <div className="bg-gray-800 p-4 rounded my-4">
      <h2 className="text-white text-2xl mb-4">
        -- UWSR Comments/{wsref.id} --
      </h2>
      <div className="mb-4">
        <button className="bg-blue-500 text-white px-4 py-2 rounded" onClick={(e: any) => setInserting(true)} > Insert </button>
      </div>
      {inserting ? (
        <div className="mb-4">
          <WsrefCommentFormComponent
            wsrefId={wsref.id}
            insertWsrefComment={async (wsrefCommentDto: any) => {
              await insertWsrefComment(wsrefCommentDto);
              setInserting(false);
            }}
            onClose={() => setInserting(false)}
          />
        </div>
      ) : null}
      {wsrefCommentList?.map((wsrefComment: any) => (
        <WsrefCommentInfoComponent
          key={wsrefComment.id}
          role={role}
          wsrefComment={wsrefComment}
          updateWsrefComment={updateWsrefComment}
          deleteWsrefComment={deleteWsrefComment}
        />
      ))}
    </div>
  );
}
