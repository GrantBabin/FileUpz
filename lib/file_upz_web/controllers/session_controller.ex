defmodule FileUpzWeb.SessionController do
  use FileUpzWeb, :controller

  alias FileUpz.User

  @spec new(Plug.Conn.t(), any()) :: Plug.Conn.t()
  def new(conn, _params) do
    render(conn, "new.html")
  end

  @spec sign_out(Plug.Conn.t(), any()) :: none()
  def login(conn, %{"session" => auth_params}) do
    user = User.get_by_email(auth_params["email"])
    case Comeonin.Bcrypt.check_pass(user, auth_params["password"]) do
      {:ok, user} ->
        conn
        |> put_session(:user_email, user.email)
        |> put_flash(:info, "Signed in successfully.")
        |> redirect(to: FileUpzWeb.Router.Helpers.user_path(conn, :index))
      _ ->
        conn
        |> put_flash(:error, "There was a problem with your username / password")
        |> render("new.html")
    end
  end

  @spec sign_out(Plug.Conn.t(), any()) :: Plug.Conn.t()
  def sign_out(conn, _params) do
    conn
    |> delete_session(:user_id)
    |> put_flash(:info, "Signed out successfully.")
    |> redirect(to: "/")
  end
end
