import { useEffect, useState } from 'react';

export function WsrefCommentFormComponent({ wsrefId, wsrefComment, insertWsrefComment, updateWsrefComment, onClose, }: {
  wsrefId?: number;
  wsrefComment?: any;
  insertWsrefComment?: (wsrefCommentDto: any) => Promise<any>;
  updateWsrefComment?: (wsrefCommentDto: any) => Promise<any>;
  onClose: () => void;
}) {
  let [comtext, setComtext] = useState('');
  useEffect(() => {
    if (wsrefComment) {
      setComtext(wsrefComment.comtext);
    }
  }, [wsrefComment]);

  return (
    <div className="bg-gray-800 p-4 rounded shadow-md">
      {wsrefComment && updateWsrefComment ? (
        <div className="text-white mb-4">Update</div>
      ) : null}
      <div className="flex mb-4">
        <textarea
          className="bg-gray-800 text-white border border-gray-700 p-2 rounded w-full"
          name="comtext"
          value={comtext}
          onChange={(e: any) => setComtext(e.target.value)}
        />
      </div>
      <div className="flex justify-end">
        <button
          className="bg-blue-500 text-white px-4 py-2 rounded mr-2"
          type="button"
          onClick={async (e: any) => {
            if (!wsrefComment && insertWsrefComment) {
              await insertWsrefComment({
                wsrefId,
                comtext,
              });
              onClose();
            }
            if (wsrefComment && updateWsrefComment) {
              await updateWsrefComment({
                comtext,
              });
              onClose();
            }
          }}
        >
          OK
        </button>
        <button
          className="bg-gray-500 text-white px-4 py-2 rounded"
          type="button"
          onClick={(e: any) => {
            onClose();
          }}
        >
          Cancel
        </button>
      </div>
    </div>
  );
}
