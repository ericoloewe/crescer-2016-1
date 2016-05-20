using CdZ.Dominio;

namespace CdZ.MVC.Models
{
    public class ImagemViewModel
    {
        public int Id { get; set; }
        public string Url { get; set; }
        public bool IsThumb { get; set; }

        public ImagemViewModel() { }

        public Imagem ToModel()
        {
            return new Imagem(Url, IsThumb);
        }
    }
}