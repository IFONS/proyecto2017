CREATE OR REPLACE PACKAGE BODY PAQUETE_PARTE2 IS

  PROCEDURE visualizar_lista_id_parte
  (
    un_cursor OUT PARTE_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT idParte FROM PARTES'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON PARTES');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_lista_id_parte;
  
  PROCEDURE visualizar_datos_parte_id
  (
    pIdParte IN PARTES.idParte%TYPE, un_cursor OUT PARTE_CURSOR
  )
  IS
  BEGIN  
    SELECT idParte,fecha,kmInicio,kmFinal,gasoil,dietas,otros,incidencias,trabajador,vehiculo,hExtra,estado INTO un_cursor FROM PARTES WHERE idParte = pIdParte;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL PARTE');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
    WHEN TOO_MANY_ROWS THEN
      RAISE_APPLICATION_ERROR(-20017, 'SE HA ENCONTRADO MAS DE UN PARTE');
  END visualizar_datos_parte_id;
  
  PROCEDURE visualizar_parte_estado 
  (
    pEstado IN PARTES.estado%TYPE, un_cursor OUT PARTE_CURSOR
  )
  IS
  BEGIN  
     OPEN un_cursor FOR 'SELECT idParte,estado FROM PARTES WHERE estado = pEstado';
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL PARTE');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_datos_parte_id;
  
  PROCEDURE visualizar_parte_id_trab
  (
    pidTrab IN PARTES.idTrab%TYPE, un_cursor OUT PARTE_CURSOR
  )
  IS
  BEGIN  
     OPEN un_cursor FOR 'SELECT idParte,estado FROM PARTES WHERE pidTrab= idTrab';
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL PARTE');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_datos_parte_id_trab;
  
END PAQUETE_PARTE2;
