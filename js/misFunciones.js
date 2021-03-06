function traerInformacionCategory(){
    $.ajax({
        url:"http://localhost:8080/api/Category/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuesta(respuesta);
        }
    });
}

function pintarRespuesta(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado1").html(myTable);
}

function guardarInformacionCategory(){
    let var2 = {
        name:$("#Cname").val(),
        description:$("#Cdescription").val()
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        
        url:"http://localhost:8080/api/Category/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}

///////////////////SKATE//////////////////////////////////////
function traerInformacionSkate(){
    $.ajax({
        url:"http://localhost:8080/api/Skate/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaSkate(respuesta);
        }
    });
}

function pintarRespuestaSkate(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].brand+"</td>";
        myTable+="<td>"+respuesta[i].year+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado2").html(myTable);
}

function guardarInformacionSkate(){
    let var3 = {
        name:$("#Bname").val(),
        brand:$("#Bbrand").val(),
        year:$("#Byear").val(),
        description:$("#Bdescription").val(),
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var3),
        
        url:"http://localhost:8080/api/Skate/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

}
//////////////////////CLIENTES//////////////////////////////////
function traerInformacionClient(){
    $.ajax({
        url:"http://localhost:8080/api/Client/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            pintarRespuestaClient(respuesta);
        }
    });
}

function pintarRespuestaClient(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].email+"</td>";
        myTable+="<td>"+respuesta[i].password+"</td>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].age+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado3").html(myTable);
}

function guardarInformacionClient(){
    let var4 = {
        email:$("#CLemail").val(),
        password:$("#CLpassword").val(),
        name:$("#CLname").val(),
        age:$("#CLage").val(),
        };
      
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var4),
        
        url:"http://localhost:8080/api/Client/save",
       
        
        success:function(response) {
                console.log(response);
            console.log("Se guardo correctamente");
            alert("Se guardo correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardo correctamente");
    
    
        }
        });

        function traerReporteStatus(){
            $.ajax({
                url:"http://localhost:8080/api/Reservation/report-status",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    console.log(respuesta);
                    pintarRespuesta(respuesta);
                }
            });
        }
        
        function pintarRespuesta(respuesta){
        
            let myTable="<table>";
            myTable+="<tr>";
               myTable+="<th>completadas</th>";
                myTable+="<td>"+respuesta.completed+"</td>";
                myTable+="<th>canceladas</th>";
                myTable+="<td>"+respuesta.cancelled+"</td>";
                myTable+="</tr>";
            myTable+="</table>";
            $("#resultadoStatus").html(myTable);
        }
        function traerReporteDate(){
            
           
        
            var fechaInicio = document.getElementById("RstarDate").value;
            var fechaCierre = document.getElementById("RdevolutionDate").value;
          console.log(fechaInicio);
          console.log(fechaCierre);
        
            $.ajax({
                url:"http://localhost:8080/api/Reservation/report-dates/"+fechaInicio+"/"+fechaCierre,
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    console.log(respuesta);
                    pintarRespuestaDate(respuesta);
                }
            });
        }
        function pintarRespuestaDate(respuesta){
        
            let myTable="<table>";
            myTable+="<tr>";
              
            for(i=0;i<respuesta.length;i++){
            myTable+="<th>total</th>";
                myTable+="<td>"+respuesta[i].devolutionDate+"</td>";
                myTable+="<td>"+respuesta[i].startDate+"</td>";
                myTable+="<td>"+respuesta[i].status+"</td>";
              
              
                myTable+="</tr>";
            }
            myTable+="</table>";
            $("#resultadoDate").html(myTable);
        }
        
        
        function traerReporteClientes(){
            $.ajax({
                url:"http://localhost:8080/api/Reservation/report-clients",
                type:"GET",
                datatype:"JSON",
                success:function(respuesta){
                    console.log(respuesta);
                    pintarRespuestaClientes(respuesta);
                }
            });
        }
        
        function pintarRespuestaClientes(respuesta){
        
            let myTable="<table>";
            myTable+="<tr>";
              
            for(i=0;i<respuesta.length;i++){
            myTable+="<th>total</th>";
                myTable+="<td>"+respuesta[i].total+"</td>";
                myTable+="<td>"+respuesta[i].client.name+"</td>";
                myTable+="<td>"+respuesta[i].client.email+"</td>";
                myTable+="<td>"+respuesta[i].client.age+"</td>";
              
                myTable+="</tr>";
            }
            myTable+="</table>";
            $("#resultadoClientes").html(myTable);
        }
        
}
