window.addEventListener('load', function () {

    //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
    //los datos que el usuario cargará del nuevo paciente
    const formulario = document.querySelector('#add_new_paciente');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    formulario.addEventListener('submit', function (event) {

       //creamos un JSON que tendrá los datos de un nuevo paciente
        const formData = {
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#dni').value,
            email:document.querySelector('#email').value,
            fechaIngreso: document.querySelector('#fecha_ingreso').value,
            calle: document.querySelector('#domicilio_calle').value,
            numero: document.querySelector('#domicilio_numero').value,
            localidad: document.querySelector('#domicilio_localidad').value,
            provincia: document.querySelector('#domicilio_provincia').value,

        };
        //invocamos utilizando la función fetch la API pacientes con el método POST que guardará
        //el paciente que enviaremos en formato JSON
        const url = '/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
            console.log("Promesa aceptada:");
                 //Si no hay ningun error se muestra un mensaje diciendo que el paciente
                 //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Paciente agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();


            })
            .catch(error => {
            console.log("Promesa rechazada:");
                    //Si hay algun error se muestra un mensaje diciendo que el paciente
                    //no se pudo guardar y se intente nuevamente
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
         document.querySelector('#dni').value = "";
         document.querySelector('#email').value = "";
         document.querySelector('#fecha_ingreso').value = "";
         document.querySelector('#domicilio_calle').value = "";
         document.querySelector('#domicilio_numero').value = "";
         document.querySelector('#domicilio_localidad').value = "";
         document.querySelector('#domicilio_provincia').value = "";

    }
});
