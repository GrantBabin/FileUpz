defmodule FileUpzWeb.UserController do
  use FileUpzWeb, :controller

  alias FileUpz.User

  @spec index(Plug.Conn.t(), any()) :: Plug.Conn.t()
  def index(conn, _params) do
    case get_session(conn, :user_email) do
      user_email ->
        user = User.get_by_email(user_email)
        render(conn, "index.html", user: user)
      :nil
        conn
        |> put_flash(:error, "You are not logged in.")
        |> redirect(to: FileUpzWeb.Router.Helpers.session_path(conn, :login))
    end
  end
end
