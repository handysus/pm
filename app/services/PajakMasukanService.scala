package services

import models.PajakMasukan

import scala.concurrent.Future

trait PajakMasukanService {

  def findAll(): Future[List[PajakMasukan]]

  def findById(id: Option[Long]): Future[Option[PajakMasukan]]

  def create(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]]

  def update(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]]

  def delete(id: Option[Long]): Future[Int]

}
