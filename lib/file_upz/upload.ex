defmodule FileUpz.Upload do
  @moduledoc """
  Represents uploads.
  """

  use Ecto.Schema
  use Arc.Ecto.Schema
  import Ecto.Changeset

  alias FileUpz.{File, Upload, User}

  @primary_key {:id, :binary_id, autogenerate: true}

  schema "resources" do
    field :file, File.Type
    belongs_to :user, User

    timestamps(type: :utc_datetime)
  end

  @required_fields ~w()a
  @optional_fields ~w()a
  @attachment_fields ~w(file)a

  @doc false
  def changeset(%Upload{} = upload, attrs) do
    upload
    |> cast(attrs, @required_fields ++ @optional_fields)
    |> validate_required(@required_fields)
    |> ensure_uuid(:id)
    |> cast_attachments(attrs, @attachment_fields)
  end

  @doc "Ensure there's a UUID in the given field"
  @spec ensure_uuid(Ecto.Changeset.t(), atom()) :: Ecto.Changeset.t()
  def ensure_uuid(changeset, field) do
    case get_field(changeset, field) do
      nil -> changeset |> put_change(field, Ecto.UUID.generate())
      _ -> changeset
    end
  end

end
