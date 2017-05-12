CREATE OR REPLACE PACKAGE BODY PAQUETE_VEHICULO2 IS
  PROCEDURE visualizar_lista_id_vehiculo
  
  (
    un_cursor OUT VEHICULO_CURSOR
  )
  
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT idVehiculo FROM VEHICULOS'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON VEHICULOS');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_lista_id_vehiculo;
  
  PROCEDURE visualizar_lista_COD_vehiculos
  
  (
    un_cursor OUT VEHICULO_CURSOR
  )
  
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT codVehiculo FROM VEHICULOS'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON VEHICULOS');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_lista_COD_vehiculos;
  
  PROCEDURE visualizar_datos_vehiculo_cod
  
  (
    pCodVehiculo IN VEHICULOS.codVehiculo%type, un_cursor OUT VEHICULO_CURSOR
  )
  
  IS
  BEGIN
    SELECT idVehiculo,codVehiculo,matricula,marca INTO un_cursor FROM VEHICULOS WHERE codVehiculo=pCodVehiculo; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON VEHICULOS');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
    WHEN TOO_MANY_ROWS THEN
      RAISE_APPLICATION_ERROR(-20012, 'SE HA ENCONTRADO MAS DE UN VEHICULO');
  END visualizar_datos_vehiculo_cod;
  
END PAQUETE_VEHICULO2;
