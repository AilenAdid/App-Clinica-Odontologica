window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del paciente
    const formulario = document.querySelector('#update_paciente_form');

    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.querySelector('#paciente_id').value;

        //creamos un JSON que tendrá los datos del paciente
        //a diferencia de un paciente nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo nuevo
        const formData = {
            id: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email:document.querySelector('#email').value,
            fechaIngreso: document.querySelector('#fecha_ingreso').value,


        };

        //invocamos utilizando la función fetch la API pacientes con el método PUT que modificará
        //el paciente que enviaremos en formato JSON
        const url = '/pacientes';
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
        //cuando se hace clic sobre el ID de un paciente del listado

        //se encarga de llenar el formulario con los datos del paciente

        //que se desea modificar

        function findBy(id) {

              const url = '/pacientes'+"/"+id;

              const settings = {

                  method: 'GET'

              }

              fetch(url,settings)

              .then(response => response.json())

              .then(data => {

                  let paciente = data;

                  document.querySelector('#paciente_id').value = paciente.id;

                  document.querySelector('#nombre').value = paciente.nombre;

                  document.querySelector('#apellido').value = paciente.apellido;

                  document.querySelector('#dni').value = paciente.dni;
                  document.querySelector('#email').value = paciente.email;
                  document.querySelector('#fecha_ingreso').value = paciente.fechaIngreso;


                  //el formulario por default está oculto y al editar se habilita

                  document.querySelector('#div_paciente_updating').style.display = "block";

              }).catch(error => {

                  alert("Error: " + error);

              })

          }
