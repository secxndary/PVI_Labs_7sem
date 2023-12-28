'use client';

import { useEffect, useState } from 'react';
import { Roles } from '../utils/roles';
import { Api } from '../utils/api';
import { WsrefListComponent } from './wsref-list.component';

export default function UwsrComponent() {
  const [role, setRole] = useState(Roles.GUEST);
  const [password, setPassword] = useState('');
  const [admin, setAdmin] = useState(false);
  const [guest, setGuest] = useState(false);

  const api = Api.getInstance();

  const authorize = async () => {
    try {
      await api.post('/uwsref', { password });
      setRole(Roles.ADMIN);
    } catch (e) {
      setRole(Roles.GUEST);
    }
  };

  const handleKeyPress = (e: KeyboardEvent) => {
    if (e.ctrlKey && e.altKey) {
      if (e.key === 'a') {
        setAdmin(!admin);
      } else if (e.key === 'g') {
        setGuest(!guest);
      }
    }
  };

  useEffect(() => {
    window.addEventListener('keydown', handleKeyPress);
    return () => window.removeEventListener('keydown', handleKeyPress);
  }, []);

  return (
    <div className="bg-gray-900 text-white p-8">
      <h1 className="text-4xl font-bold mb-4">-- UWSR --</h1>
      {admin && (
        <div>
          <input
            className="bg-gray-800 text-white border border-gray-700 p-2 rounded"
            type="text"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
          <button
            className="bg-blue-500 text-white px-4 py-2 rounded ml-2"
            onClick={async (e) => {
              await authorize();
              setAdmin(false);
            }}
          >
            Set
          </button>
          <button
            className="bg-red-500 text-white px-4 py-2 rounded ml-2"
            onClick={(e) => {
              setRole(Roles.GUEST);
              setAdmin(false);
            }}
          >
            Reset
          </button>
        </div>
      )}
      {guest && (
        <div>
          <button
            className="bg-red-500 text-white px-4 py-2 rounded ml-2"
            onClick={(e) => {
              setRole(Roles.GUEST);
              setGuest(false);
            }}
          >
            Reset
          </button>
        </div>
      )}
      <WsrefListComponent role={role} />
    </div>
  );
}
