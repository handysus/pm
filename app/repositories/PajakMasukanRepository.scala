package repositories

import models.PajakMasukan

import scala.concurrent.Future


trait PajakMasukanRepository {

  def findAll(): Future[List[PajakMasukan]]

  def findById(id: Option[Long]): Future[Option[PajakMasukan]]

  def create(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]]

}
