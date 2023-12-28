import { useEffect, useState } from 'react';

export function WsrefFormComponent({ wsref, insertWsref, updateWsref, onClose, }: {
  wsref?: any;
  insertWsref?: (wsrefDto: any) => Promise<any>;
  updateWsref?: (wsrefDto: any) => Promise<any>;
  onClose: () => void;
}) {
  let [url, setUrl] = useState('');
  let [description, setDescription] = useState('');

  useEffect(() => {
    if (wsref) {
      setUrl(wsref.url);
      setDescription(wsref.description);
    }
  }, [wsref]);

  return (
    <div className="bg-gray-800 p-4 rounded my-4">
      <div className="flex mb-4">
        <input
          className="bg-gray-800 text-white border border-gray-700 p-2 rounded w-full"
          name="url"
          value={url}
          placeholder="http://url-useful-website-reference"
          onChange={(e: any) => setUrl(e.target.value)}
        />
      </div>
      <div className="mb-4">
        <input
          className="bg-gray-800 text-white border border-gray-700 p-2 rounded w-full"
          name="description"
          value={description}
          placeholder="key-word, key-word, ..."
          onChange={(e: any) => setDescription(e.target.value)}
        />
      </div>
      <div className="flex justify-end">
        <button
          className="bg-blue-500 text-white px-4 py-2 rounded mr-2"
          type="button"
          onClick={async (e: any) => {
            if (!wsref && insertWsref) {
              await insertWsref({ url, description, });
              onClose();
            }
            if (wsref && updateWsref) {
              await updateWsref({ url, description, });
              onClose();
            }
          }}
        >
          OK
        </button>
        <button
          className="bg-gray-500 text-white px-4 py-2 rounded"
          type="button"
          onClick={(e: any) => { onClose(); }}
        >
          Cancel
        </button>
      </div>
    </div>
  );
}
