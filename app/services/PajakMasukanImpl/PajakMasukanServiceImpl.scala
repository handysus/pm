package services.PajakMasukanImpl

import javax.inject.{Inject, Singleton}
import models.PajakMasukan
import repositories.PajakMasukanRepository
import services.PajakMasukanService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class PajakMasukanServiceImpl @Inject() (pajakMasukanRepository: PajakMasukanRepository) (implicit ex: ExecutionContext) extends PajakMasukanService{
  override def findAll(): Future[List[PajakMasukan]] = {
    pajakMasukanRepository.findAll()
  }

  override def findById(id: Option[Long]): Future[Option[PajakMasukan]] = {
    pajakMasukanRepository.findById(id)
  }

  override def create(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]] = {
    pajakMasukanRepository.create(pajakMasukan)
  }

  override def update(pajakMasukan: PajakMasukan): Future[Option[PajakMasukan]] = {
    pajakMasukanRepository.update(pajakMasukan)
  }

  override def delete(id: Option[Long]): Future[Int] = {
    pajakMasukanRepository.delete(id)
  }
}
