defmodule FileUpz.Repo do
  use Ecto.Repo,
    otp_app: :file_upz,
    adapter: Ecto.Adapters.Postgres
end
