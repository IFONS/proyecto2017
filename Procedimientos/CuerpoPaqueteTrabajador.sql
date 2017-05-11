CREATE OR REPLACE PACKAGE BODY PAQUETE_TRABAJADOR2 IS
  

  PROCEDURE visualizar_lista_dnis
  (
    un_cursor OUT TRABAJADOR_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT dni FROM trabajadores'; 
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON TRABAJADORES');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_lista_dnis;
  
  PROCEDURE visualizar_lista_dnis_centro
  (
    pidCentro IN TRABAJADOR.CENTRO%TYPE, un_cursor OUT TRABAJADOR_CURSOR
  )
  IS
  BEGIN
    OPEN un_cursor FOR 'SELECT dni FROM trabajadores WHERE idCentro = pidCentro';
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20107, 'NO SE ENCONTRARON TRABAJADORES');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_lista_dnis_centro;
  
  PROCEDURE visualizar_datos_trabajador
  (
    pDni IN TRABAJADORES.DNI%TYPE, un_cursor OUT TRABAJADOR_CURSOR
  )
  IS
  BEGIN  
     SELECT idTrab, dni, nombre, apellidouno, apellidodos, calle, portal, piso, mano, telefempre, telefperso, salario , fecha_nac , centro INTO un_cursor FROM TRABAJADORES WHERE dni = pDni;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RAISE_APPLICATION_ERROR(-20009,'NO SE ENCONTRÓ EL TRABAJADOR');
    WHEN TOO_MANY_ROWS THEN
    RAISE_APPLICATION_ERROR(-20010, 'SE HA ENCONTRADO MAS DE UN TRABAJADOR');
    WHEN DEFAULT THEN
      RAISE_APPLICATION_ERROR(-20011, 'ERROR DESCONOCIDO');
  END visualizar_datos_trabajador;

  
END PAQUETE_TRABAJADOR2;
  
  
