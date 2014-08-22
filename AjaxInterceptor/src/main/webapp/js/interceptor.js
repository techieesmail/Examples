/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function(xhr) {
    var send = xhr.prototype.send;
    xhr.prototype.send = function(data) {
       
        this.onreadystatechange = function()
        {
            //alert('interceptor ready');
            if (this.readyState == 4)
            {
                alert('From Interceptor ' + this.responseText);

            }
        }
        
         send.call(this, data);
        
    }
})(XMLHttpRequest);
