//El evento load se ejecuta al cargar la página que muestra la lista de pacientes
window.addEventListener('load', function () {

   (function(){



     //con fetch invocamos a la API de pacientes con el método GET

     //nos devolverá un JSON con una colección de pacientes

     const url = '/pacientes';

     const settings = {

       method: 'GET'

     }



     fetch(url,settings)

     .then(response => response.json())

     .then(data => {

     //recorremos la colección de pacientes del JSON

        for(paciente of data){

           //por cada paciente armaremos una fila de la tabla

           //cada fila tendrá un ID que luego nos permitirá

           //borrar la fila si eliminamos el paciente

           var table = document.getElementById("pacienteTable");

           var pacienteRow =table.insertRow();

           let tr_id = 'tr_' + paciente.id;

           pacienteRow.id = tr_id;

            console.log(paciente)
           //por cada paciente creamos un botón delete que

           //agregaremos en cada fila para poder eliminar la misma

           //dicho botón invocará a la función de JavaScript deleteByKey que se encargará

           //de llamar a la API para eliminar un paciente

           let deleteButton = '<button' +

                                     ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +

                                     ' type="button" onclick="deleteBy('+paciente.id+')"' +

                                     'class="btn btn-danger btn_delete">' +

                                     '&times' +

                                     '</button>';



           //por cada paciente creamos un botón que muestra el ID

           //y que al hacerle clic invocará a la función de JavaScript findBy

           //que se encargará de buscar el paciente que queremos modificar

           //y mostrar los datos del mismo en un formulario.

           let updateButton = '<button' +

                                     ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +

                                     ' type="button" onclick="findBy('+paciente.id+')"' +

                                     ' class="btn btn-info btn_id">' +

                                     paciente.id +

                                     '</button>';



           //armamos cada columna de la fila

           //como primera columna pondremos el botón modificar

           //luego los datos del paciente

           //como última columna, el botón eliminar

           pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +


                 '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                 '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                 '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                 '<td class=\"td_dni\">' + paciente.email + '</td>' +
                 '<td class=\"td_fecha_ingreso\">' + paciente.fechaIngreso + '</td>' +


                   '<td>' + deleteButton + '</td>';



       };



   })

   })



   (function(){

     let pathname = window.location.pathname;

     if (pathname == "/pacienteList.html") {

         document.querySelector(".nav .nav-item a:last").addClass("active");

     }

   })





   })