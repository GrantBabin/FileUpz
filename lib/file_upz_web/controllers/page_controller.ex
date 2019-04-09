defmodule FileUpzWeb.PageController do
  use FileUpzWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end
end
