defmodule FileUpzWeb.Router do
  use FileUpzWeb, :router

  pipeline :browser do
    plug :accepts, ["html"]
    plug :fetch_session
    plug :fetch_flash
    plug :protect_from_forgery
    plug :put_secure_browser_headers
  end

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/", FileUpzWeb do
    pipe_through :browser

    get "/", PageController, :index
    get "/users", UserController, :index
    get "/login", SessionController, :new
    post "/login", SessionController, :login
    delete "/sign-out", SessionController, :sign_out
  end

  # Other scopes may use custom stacks.
  # scope "/api", FileUpzWeb do
  #   pipe_through :api
  # end
end
