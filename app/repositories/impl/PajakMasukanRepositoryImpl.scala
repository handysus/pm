package repositories.impl

import javax.inject.{Inject, Singleton}
import models.PajakMasukan
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

@Singleton
class PajakMasukanRepositoryImpl @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) {
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class PajakMasukan(tag: Tag) extends Table[PajakMasukan](tag, "pm") {
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)

    def kodeJenisTransaksi = column[String]("kodeJenisTransaksi")

    def fgPengganti = column[String]("fgPengganti")

    def noFaktur = column[String]("noFaktur")

    def masaPajak = column[String]("masaPajak")

    def tahunPajak = column[String]("tahunPajak")

    def tanggalFaktur = column[String]("tanggalFaktur")

    def npwp = column[String]("npwp")

    def nama = column[String]("nama")

    def alamat = column[String]("alamat")

    def jumlahDpp = column[Double]("jumlahDpp")

    def jumlahPpn = column[Double]("jumlahPpn")

    def jumlahPpnbm = column[Double]("jumlahPpnbm")

    def referensi = column[Option[String]]("referensi")

    def * = (
      id,
      kodeJenisTransaksi,
      fgPengganti,
      noFaktur,
      masaPajak,
      tahunPajak,
      tanggalFaktur,
      npwp,
      nama,
      alamat,
      jumlahDpp,
      jumlahPpn,
      jumlahPpnbm,
      referensi
    ) <> ((PajakMasukan.apply _).tupled, PajakMasukan.unapply)
  }

}
