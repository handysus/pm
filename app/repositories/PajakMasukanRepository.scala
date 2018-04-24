package repositories

import models.PajakMasukan

import scala.concurrent.Future


trait PajakMasukanRepository {
  def findAll(): Future[List[PajakMasukan]]

  def create(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]]

}
