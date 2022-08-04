function deleteBy(id)

{

         //con fetch invocamos a la API de pacientes con el método DELETE

         //pasándole el ID en la URL

         const url = '/pacientes/'+ id;

         const settings = {

             method: 'DELETE'

         }

         fetch(url,settings)

         .then(response => response.json())



         //borrar la fila del paciente eliminado

         let row_id = "#tr_" + id;

         document.querySelector(row_id).remove();

}