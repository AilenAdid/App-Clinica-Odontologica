window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del turno
    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        let turnoId = document.querySelector('#turno_id').value;

        //creamos un JSON que tendrá los datos del turno
        //a diferencia de un turno nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo nuevo
        const formData = {
            id: document.querySelector('#turno_id').value,
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value,
            odontologo: document.querySelector('#odontologo').value,
            paciente:document.querySelector('#paciente').value,



        };

        //invocamos utilizando la función fetch la API turnos con el método PUT que modificará
        //el turno que enviaremos en formato JSON
        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })

 })
 //Es la función que se invoca
        //cuando se hace clic sobre el ID de un turno del listado

        //se encarga de llenar el formulario con los datos del turno

        //que se desea modificar

        function findBy(id) {

              const url = '/turnos'+"/"+id;

              const settings = {

                  method: 'GET'

              }

              fetch(url,settings)

              .then(response => response.json())

              .then(data => {

                  let turno = data;

                  document.querySelector('#turno_id').value = turno.id;

                  document.querySelector('#fecha').value = turno.fecha;

                  document.querySelector('#hora').value = turno.hora;

                  document.querySelector('#odontologo').value = turno.odontologo_id;

                  document.querySelector('#paciente').value = turno.paciente_id;



                  //el formulario por default está oculto y al editar se habilita

                  document.querySelector('#div_turno_updating').style.display = "block";

              }).catch(error => {

                  alert("Error: " + error);

              })

          }
