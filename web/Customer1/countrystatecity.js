/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 var states=new Array();
 states['India']=new Array('Maharashtra','New Delhi','Tamil Nadu');
 states['Australia']=new Array('Maharashtra','New Delhi','Tamil Nadu');
 states['India']=new Array('Maharashtra','New Delhi','Tamil Nadu');
 
 var cities=new Array();
 
 cities['India']=new Array();
 cities['India']['Maharashtra']=new Array('Mumbai','Pune');
 cities['India']['New Delhi']=new Array('Noida','Dwarka');
 cities['India']['Tamil Nadu']=new Array('Chennai');
 
 function setStates()
 {
     cntrysel=document.getElementById('country');
     stateList=states[cntrysel.value];
     changeSelect('state',stateList,stateList);
     setCities();
 }
 
 function setCities()
 {
     cntrysel=document.getElementById('country');
     statesel=document.getElementById('state');
     cityList=cities[cntrysel.value][stateSel.value];
     changeSelect('city',cityList,cityList);
 }
 
 function changeSelect(fieldid,newOptions,newValues)
 {
     selectField=document.getElementById(fieldid);
     selectField.options.length=0;
     for(i=0;i<newOptions.length;i++)
         selectField.options[selectField.length]=new Option(newOptions[i],newValues[i]);
 }
 
 function addLoadEvent(func)
 {
     var oldonload=window.onload;
     if(typeof window.onload!='function')
     {
         window.onload=func;
     }
     else
     {
         window.onload=function()
         {
             if(oldonload)
             {
                 oldonload();
             }
             func();
         }
     }
 }
 
 addLoadEvent(function()
 {
     setStates();
 });
 

