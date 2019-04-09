defmodule FileUpz.User do
  use Ecto.Schema

  import Ecto.Changeset

  alias Comeonin.Bcrypt
  alias FileUpz.{Repo, Upload, User}

  schema "users" do
    field :email, :string
    field :encrypted_password, :string

    has_many :uploads, Upload
  end

  @spec changeset(
          FileUpz.User.t(),
          :invalid | %{optional(:__struct__) => none(), optional(atom() | binary()) => any()}
        ) :: Ecto.Changeset.t()
  def changeset(%User{} = user, attrs) do
    user
    |> cast(attrs, [:username, :encrypted_password])
    |> unique_constraint(:username)
    |> validate_required([:username, :encrypted_password])
    |> update_change(:encrypted_password, &Bcrypt.hashpwsalt/1)
  end

  def get_by_email(email) when is_nil(email), do: :nil

  def get_by_email(email) do
    Repo.get_by(User, email: email)
  end
end
