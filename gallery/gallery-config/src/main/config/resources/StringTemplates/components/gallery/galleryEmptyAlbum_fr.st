$if(albumPart)$
  Cet album ne contient pas encore de sous albums.<br/>
  Pour en ajouter un, utilisez une des solutions suivantes :
  <ul>
    <li>glisser un dossier dans la zone de glisser-déposer</li>
    <li>l'opération "$albumOperation$"</li>
    <li><a href="$albumUrl$">cliquez ici directement</a></li>
  </ul><br/><br/>
$endif$
Cet album ne contient pas encore de média.
$if(mediaPart)$<br/>
  Pour en ajouter un, utilisez une des solutions suivantes :
  <ul>
    <li>la zone de glisser-déposez</li>
    <li>l'opération "$photoOperation$"<br/>(<a href="$photoUrl$">cliquez ici directement</a>)</li>
    <li>l'opération "$videoOperation$"<br/>(<a href="$videoUrl$">cliquez ici directement</a>)</li>
    <li>l'opération "$soundOperation$"<br/>(<a href="$soundUrl$">cliquez ici directement</a>)</li>
  </ul>
$endif$