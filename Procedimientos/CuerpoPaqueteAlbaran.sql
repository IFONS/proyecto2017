CREATE OR REPLACE PACKAGE BODY PAQUETE_ALBARAN2 IS
  
  
  
  PROCEDURE visualizar_lista_id_albaran
  (
    un_cursor OUT ALBARAN_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT idAlbaran FROM ALBARANES'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON ALBARANES');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
      
  END visualizar_lista_id_albaran;
  
  PROCEDURE visualizar_datos_albaran_id
  (
    pidAlbaran IN ALBARANES.idAlbaran%type, un_cursor OUT ALBARAN_CURSOR
  )
  IS
  BEGIN
      SELECT idAlbaran,horaSalida,horaLlegada,matricula,parte INTO un_cursor FROM ALBARANES WHERE idAlbaran=pidAlbaran; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON ALBARANES');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
    WHEN TOO_MANY_ROWS THEN
      RAISE_APPLICATION_ERROR(-20015, 'SE HA ENCONTRADO MAS DE UN ALBARAN');
      
  END visualizar_datos_albaran_id;
  
  PROCEDURE visualizar_datos_albaran_id_parte
  (
    pidParte IN ALBARANES.idParte%type, un_cursor OUT ALBARAN_CURSOR
  )
  IS
  BEGIN
     OPEN un_cursor FOR 'SELECT idAlbaran,horaSalida,horaLlegada,matricula,parte FROM ALBARANES WHERE idParte=pidParte'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON ALBARANES');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
      
      
  END visualizar_datos_albaran_id_parte;
  
  
 
END PAQUETE_ALBARAN2;
  