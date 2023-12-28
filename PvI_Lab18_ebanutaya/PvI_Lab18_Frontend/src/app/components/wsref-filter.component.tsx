export function WsrefFilterComponent({
  filter,
  setFilter,
  submit,
  onClose,
}: {
  filter: string;
  setFilter: (value: ((prevState: string) => string) | string) => void;
  submit: () => Promise<void>;
  onClose: () => void;
}) {
  return (
    <div className="bg-gray-800 p-4 rounded my-4">
      <div className="flex mb-4">
        <input
          className="bg-gray-800 text-white border border-gray-700 p-2 rounded w-full"
          name="filter"
          value={filter}
          placeholder="key-word, key-word, ..."
          onChange={(e: any) => setFilter(e.target.value)}
        />
      </div>
      <div className="flex justify-end">
        <button
          className="bg-blue-500 text-white px-4 py-2 rounded mr-2"
          onClick={async (e: any) => {
            await submit();
            onClose();
          }}
        >
          OK
        </button>
        <button
          className="bg-gray-500 text-white px-4 py-2 rounded"
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
