# CRUD rest api using Play Framework

Library:
Slick

Routes
<pre>
GET     /get                         controllers.HomeController.findAllPm
GET     /get/:id                     controllers.HomeController.findById(id: Long)
POST    /create                      controllers.HomeController.createPm
PUT     /update                      controllers.HomeController.updatePm
DELETE  /delete/:id                  controllers.HomeController.delete(id: Long)
</pre>

<pre>
Database Name: pm
Postgresql
</pre>

Schema SQL :
<pre>
CREATE TABLE pm
(
  id bigserial NOT NULL PRIMARY KEY,
  kodejenistransaksi character varying(100),
  fgpengganti character varying(100),
  nofaktur character varying(100),
  masapajak character varying(100),
  tahunpajak character varying(100),
  tanggalfaktur character varying(100),
  npwp character varying(100),
  nama character varying(100),
  alamat character varying(100),
  jumlahdpp integer,
  jumlahppn integer,
  jumlahppnbm integer,
  referensi character varying(100)
)
</pre>