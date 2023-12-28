import { useEffect, useState } from 'react';
import { Roles } from '../utils/roles';
import { Api } from '../utils/api';
import { WsrefFormComponent } from './wsref-form.component';
import { WsrefFilterComponent } from './wsref-filter.component';
import { WsrefInfoComponent } from './wsref-info.component';

export function WsrefListComponent({ role }: { role: Roles }) {
  const [wsrefList, setWsrefList] = useState<any[]>();
  const [inserting, setInserting] = useState(false);
  const [filtering, setFiltering] = useState(false);
  const [filter, setFilter] = useState('');

  const api = Api.getInstance();

  const loadWsrefs = async () => {
    let wsrefsData = await api.get(`/wsref`, { filter: filter?.length > 0 ? filter : undefined, });
    if (wsrefsData!) setWsrefList(wsrefsData);
  };

  const insertWsref = async (wsrefDto: any) => {
    await api.post(`/wsref`, wsrefDto);
    await loadWsrefs();
  };

  const updateWsref = async (id: number, wsrefDto: any) => {
    await api.put(`/wsref/${id}`, wsrefDto);
    await loadWsrefs();
  };

  const deleteWsref = async (id: number) => {
    await api.delete(`/wsref/${id}`);
    await loadWsrefs();
  };

  const incrementWsref = async (id: number) => {
    await api.put(`/wsref/${id}/plus`);
    await loadWsrefs();
  };

  const decrementWsref = async (id: number) => {
    await api.put(`/wsref/${id}/minus`);
    await loadWsrefs();
  };

  useEffect(() => {
    loadWsrefs();
  }, []);

  return (
    <div className="container mx-auto p-4">
      <div className="mb-4">
        {role === Roles.ADMIN ? (
          <button
            className="bg-blue-500 text-white px-4 py-2 rounded mr-2"
            onClick={(e: any) => setInserting(true)}
          >
            Insert
          </button>
        ) : null}
        <button
          className="bg-gray-500 text-white px-4 py-2 rounded"
          onClick={(e: any) => setFiltering(true)}
        >
          Filter
        </button>
      </div>
      {inserting ? (
        <div className="mb-4">
          <WsrefFormComponent
            insertWsref={async (wsrefDto: any) => {
              await insertWsref(wsrefDto);
              setInserting(false);
            }}
            onClose={() => setInserting(false)}
          />
        </div>
      ) : null}
      {filtering ? (
        <div className="mb-4">
          <WsrefFilterComponent
            filter={filter}
            setFilter={setFilter}
            submit={async () => {
              await loadWsrefs();
              setFiltering(false);
            }}
            onClose={() => setFiltering(false)}
          />
        </div>
      ) : null}
      {wsrefList?.map((wsref: any) => (
        <WsrefInfoComponent
          key={wsref.id}
          role={role}
          wsref={wsref}
          updateWsref={updateWsref}
          deleteWsref={deleteWsref}
          incrementWsref={incrementWsref}
          decrementWsref={decrementWsref}
        />
      ))}
    </div>
  );
}
