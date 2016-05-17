using System;
using System.Data.SqlClient;

namespace LojaNinja.Repositorio.Extensions
{
    public static class SqlDataReaderExtension
    {
        public static int ParseInt(this SqlDataReader dataReader, string coluna)
        {
            return Convert.ToInt32(dataReader[coluna]);
        }
    }
}
