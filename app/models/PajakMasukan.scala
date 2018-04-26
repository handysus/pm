package models

import play.api.libs.json._

case class PajakMasukan( id: Option[Long] = None,
                         kodeJenisTransaksi: String,
                         fgPengganti: String,
                         noFaktur: String,
                         masaPajak: String,
                         tahunPajak: String,
                         tanggalFaktur: String,
                         npwp: String,
                         nama: String,
                         alamat: String,
                         jumlahDpp: Double,
                         jumlahPpn: Double,
                         jumlahPpnbm: Double,
                         referensi: Option[String]
                       )

object PajakMasukan{
  implicit val pajakMasukan = Json.format[PajakMasukan]
}