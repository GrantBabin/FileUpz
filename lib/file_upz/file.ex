defmodule FileUpz.File do
  use Arc.Definition
  use Arc.Ecto.Definition

  @allowed_extensions ~w(.doc .docx .xls .xlsx .pdf .jpg .png)
  def allowed_extensions, do: @allowed_extensions

  @doc """
  Overrides Arc.Definition function.

  Validate the file before uploading.

  Accepts {version, {file, scope}}
  Return true/false
  """
  def validate({file, _}) do
    extension = Path.extname(file.file_name)
    Enum.member?(allowed_extensions(), extension)
  end

  @doc """
  Overrides Arc.Definition function.

  Set the uploaded file's filename

  Accepts {version, {file, scope}}
  Return a string of the filename without extension.
  """
  def filename(version, {file, resource}) do
    extension = Path.extname(file.file_name)

    basename =
      file.file_name
      |> Path.basename(extension)
      |> sanitize_filename()

    "#{resource.id}-#{basename}-#{version}"
  end

  @doc """
  Overrides Arc.Definition function.

  Set the uploaded file's directory

  Accepts {version, {file, scope}}
  Return a string of the relative file path from root.
  """
  def storage_dir(_version, {_file, _resource}) do
    "uploads/resources/activities"
  end

  @spec sanitize_filename(String.t()) :: String.t()
  def sanitize_filename(filename) do
    filename |> String.replace(~r/[^A-Za-z0-9]/, "_", global: true)
  end
end
