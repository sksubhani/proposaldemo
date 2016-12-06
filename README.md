# proposaldemo
Generate a PDF using itext pdf library using Spring MVC framework.

<u><b> Usage and URLs: </b> </u> <br/>
<b> Base URL </b><br/>
<a href="http://localhost:8080/proposaldemo/"> http://localhost:8080/proposaldemo/ </a> <br/>

<b>View PDF </b> <br/>
<a href="http://localhost:8080/proposaldemo/showProposal"> http://localhost:8080/proposaldemo/showProposal </a> <br/>

<b> Receive JSON input and convert to Java object and display </b> <br/>
<a href="http://localhost:8080/proposaldemo/processRequest"> http://localhost:8080/proposaldemo/processRequest </a> <br/>

Note: The input expected in POST method as body/payload. Use Postman or Advanced Rest Client or SOAP UI to test this URL. Send the input as below: <br/>
<b> Header </b> <br>
<pre> Content-Type: application/json </pre>
<b> Body: </b> <br/>
<pre>
{
  "empNumber":101,
  "empName":"Subhani",
  "salary":10000.00,
  "deptNum":"D101"
}
</pre>
