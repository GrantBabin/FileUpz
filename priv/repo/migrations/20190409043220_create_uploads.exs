defmodule FileUpz.Repo.Migrations.CreateUploads do
  use Ecto.Migration

  def change do
    create table(:uploads) do
      add :file, :string
      add :user_id, references(:users)

      timestamps()
    end
  end
end
