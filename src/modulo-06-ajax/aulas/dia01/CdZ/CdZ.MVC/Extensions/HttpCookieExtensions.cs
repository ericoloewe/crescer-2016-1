using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace System.Web
{
    public static class HttpCookieExtensions
    {
        public static void Expirar(this HttpCookie cookie)
        {
            cookie.Expires = DateTime.Now.AddDays(-1d);
        }
    }
}