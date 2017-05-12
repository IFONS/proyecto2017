 CREATE OR REPLACE PACKAGE BODY PAQUETE_CENTRO2 IS

 
  
  PROCEDURE visualizar_lista_nombre_centro
  (
    un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT nombre FROM centros'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON CENTROS');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_lista_nombre_centro;
  
 
  PROCEDURE visualizar_datos_centro_nombre
  (
    pNombreCentro IN CENTROS.nombre%TYPE, un_cursor OUT CENTRO_CURSOR
  )
  IS
  BEGIN
      SELECT idCentro, nombre, calle, numero, cp, ciudad, provincia, telefono INTO un_cursor FROM centros WHERE nombre = pNombreCentro;
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL CENTRO');
      WHEN DEFAULT THEN
        RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
      WHEN TOO_MANY_ROWS THEN
        RAISE_APPLICATION_ERROR(-20018, 'SE HA ENCONTRADO MAS DE UN CENTRO');
      
  END visualizar_datos_centro_nombre;


  
END PAQUETE_CENTRO2;