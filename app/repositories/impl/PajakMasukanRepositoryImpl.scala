package repositories.impl

import javax.inject.{Inject, Singleton}
import models.PajakMasukan
import play.api.db.slick.DatabaseConfigProvider
import repositories.PajakMasukanRepository
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class PajakMasukanRepositoryImpl @Inject()(dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext) extends PajakMasukanRepository{
  private val dbConfig = dbConfigProvider.get[JdbcProfile]

  import dbConfig._
  import profile.api._

  private class PajakMasukanTable(tag: Tag) extends Table[PajakMasukan](tag, "pm") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def kodeJenisTransaksi = column[String]("kodejenistransaksi")
    def fgPengganti = column[String]("fgpengganti")
    def noFaktur = column[String]("nofaktur")
    def masaPajak = column[String]("masapajak")
    def tahunPajak = column[String]("tahunpajak")
    def tanggalFaktur = column[String]("tanggalfaktur")
    def npwp = column[String]("npwp")
    def nama = column[String]("nama")
    def alamat = column[String]("alamat")
    def jumlahDpp = column[Double]("jumlahdpp")
    def jumlahPpn = column[Double]("jumlahppn")
    def jumlahPpnbm = column[Double]("jumlahppnbm")
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
  private val p = TableQuery[PajakMasukanTable]

  private def filterById(id: Option[Long]): DBIO[Option[PajakMasukan]] = p.filter(_.id === id).result.headOption

  override
  def findAll(): Future[List[PajakMasukan]] = db.run{p.to[List].result}

  override
  def create(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]] = db.run{
    (p.map(pm =>(pm.kodeJenisTransaksi, pm.fgPengganti, pm.noFaktur, pm.masaPajak, pm.tahunPajak,
      pm.tanggalFaktur, pm.npwp, pm.nama, pm.alamat, pm.jumlahDpp, pm.jumlahPpn, pm.jumlahPpnbm, pm.referensi))
      returning p.map(_.id)
      into((a, id)=> Some(PajakMasukan(id, a._1, a._2, a._3, a._4, a._5, a._6, a._7, a._8, a._9, a._10, a._11, a._12, a._13)))
      ) += (pajakMasukan.kodeJenisTransaksi, pajakMasukan.fgPengganti, pajakMasukan.noFaktur, pajakMasukan.masaPajak, pajakMasukan.tahunPajak,
    pajakMasukan.tanggalFaktur, pajakMasukan.npwp, pajakMasukan.nama, pajakMasukan.alamat, pajakMasukan.jumlahDpp, pajakMasukan.jumlahPpn,
    pajakMasukan.jumlahPpnbm, pajakMasukan.referensi)
  }

  override def findById(id: Option[Long]): Future[Option[PajakMasukan]] = db.run { filterById(id) }

}