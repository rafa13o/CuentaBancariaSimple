# CuentaBancariaSimple

Programa que simula una cuenta bancaria en JAJA. Para ello, se crean dos objetos:
  * Objeto Cliente:
      - Código Cliente: int
      - DNI: String
      - Nombre: String
      - Apellidos: String
      - Dirección: String
      - Teléfono: String


  * Objeto CuentaBancaria:
      - CodigoCuentaCliente: String
      - Titular: Cliente
      - Saldo: double
      - FechaApertura: LocalDate

A tener en cuenta:
  * El codigoCuentaCliente (CCC) se crea automáticamente pasándole el número de entidad y el número de cuenta. El programa deberá hacer los cálculos necesarios para conseguir los dígitos de control.
  * En la cuenta bancaria se puede ingresar, retirar dinero y recibir intereses el día 15 de cada mes.
  * A la hora de imprimir la información de la cuenta bancaria, la fecha deberá ir con el formato dd-mm-yyyy y el CCC como 1234-5678-12-1234567890, donde los primeros ocho dígitos son el número de entidad, los siguientes dos dígitos son los dígitos de control y los últimos diez dígitos son el número de cuenta.
