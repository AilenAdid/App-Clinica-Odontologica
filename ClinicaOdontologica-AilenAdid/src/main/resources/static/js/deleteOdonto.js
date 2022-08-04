function deleteBy(id)

{

         //con fetch invocamos a la API de odontologos con el método DELETE

         //pasándole el ID en la URL

         const url = '/odontologos/'+ id;

         const settings = {

             method: 'DELETE'

         }

         fetch(url,settings)

         .then(response => response.json())



         //borrar la fila del odontologo eliminado

         let row_id = "#tr_" + id;

         document.querySelector(row_id).remove();

}