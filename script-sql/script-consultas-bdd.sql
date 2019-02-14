-- query: detalle de inscripciones pre-abrobadas
select 
  e.nombre as nombre_escuela, 
  a.numero_de_documento as documento_aspirante, 
  a.apellido as apellido_aspirante, 
  a.nombre as nombre_aspirante, 
  c.descripcion as descripcion_competencia, 
  c.fecha as fecha_competencia, 
  ca.descripcion as descripcion_categoria, 
  es.descripcion as descripcion_estado  
from
  Inscripcion as i 
    inner join Aspirante as a on (i.numero_de_documento_aspirante=a.numero_de_documento)
	inner join Competencia as c on (i.id_competencia=c.id_competencia)
    inner join Categoria as ca on (i.id_categoria=ca.id_categoria) 
    inner join Escuela as e on (a.id_escuela=e.id_escuela)
    inner join Estado as es on (i.id_estado=es.id_estado)
where 
  es.id_estado=2 
order by
  e.nombre, 
  a.numero_de_documento;

-- query: competencias con sus categorias disponibles
select 
  c.descripcion as descripcion_competencia, 
  ca.descripcion as descripcion_categoria, 
  ca.edad_desde, 
  ca.edad_hasta
from
  Competencia as c 
    inner join CompetenciaCategoria as cc on (c.id_competencia=cc.id_competencia)
    inner join Categoria as ca on (cc.id_categoria=ca.id_categoria) 
order by 
  c.descripcion, 
  ca.descripcion;
