 CREATE OR REPLACE PACKAGE BODY PAQUETE_CENTRO2 IS

  PROCEDURE visualizar_lista_ids_centro
  (
    un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor  FOR
      select idCentro 
      from centros; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON CENTROS');
  END visualizar_lista_ids_centro;
  
  PROCEDURE visualizar_lista_nombre_centro
  (
    un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select nombre
      from centros; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON CENTROS');
  END visualizar_lista_nombre_centro;
  
  PROCEDURE visualizar_datos_centro
  (
    pIdCentro IN CENTROS.idCentro%TYPE, un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idCentro, nombre, calle, numero, cp, ciudad, provincia, telefono from centros where idCentro = pIdCentro;
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL CENTRO');
  END visualizar_datos_centro;
  
  PROCEDURE visualizar_datos_centro_nombre
  (
    pNombreCentro IN CENTROS.nombre%TYPE, un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      select idCentro, nombre, calle, numero, cp, ciudad, provincia, telefono from centros where nombre = pNombreCentro;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL CENTRO');
  END visualizar_datos_centro_nombre;

  PROCEDURE buscar_centro_por_id
  (
    pIdCentro IN CENTROS.idCentro%TYPE, un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      SELECT nombre FROM CENTROS WHERE idCentro = pIdCentro;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL CENTRO');
  END buscar_centro_por_id;
  
  PROCEDURE buscar_centro_por_nombre
  (
    pNombreCentro IN CENTROS.nombre%TYPE, un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR
      SELECT idCentro FROM CENTROS WHERE nombre = pNombreCentro;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL CENTRO');
  END buscar_centro_por_nombre;
END PAQUETE_CENTRO2;