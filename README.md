<https://chromewebstore.google.com/detail/copyfish-%F0%9F%90%9F-free-ocr-soft/eenjdnjldapjajjofmldgmkjaienebbj?pli=1>

# Ghid Design Patterns - Gang of Four (GoF)

Acest document prezintă o descriere detaliată a celor 23 de design patterns descrise în "Design Patterns: Elements of Reusable Object-Oriented Software" de către Gang of Four (GoF).

## Cuprins

1. [Creational Patterns](#creational-patterns)
   - [Abstract Factory](#abstract-factory)
   - [Builder](#builder)
   - [Factory Method](#factory-method)
   - [Prototype](#prototype)
   - [Singleton](#singleton)
2. [Structural Patterns](#structural-patterns)
   - [Adapter](#adapter)
   - [Bridge](#bridge)
   - [Composite](#composite)
   - [Decorator](#decorator)
   - [Facade](#facade)
   - [Flyweight](#flyweight)
   - [Proxy](#proxy)
3. [Behavioral Patterns](#behavioral-patterns)
   - [Chain of Responsibility](#chain-of-responsibility)
   - [Command](#command)
   - [Interpreter](#interpreter)
   - [Iterator](#iterator)
   - [Mediator](#mediator)
   - [Memento](#memento)
   - [Observer](#observer)
   - [State](#state)
   - [Strategy](#strategy)
   - [Template Method](#template-method)
   - [Visitor](#visitor)

## Creational Patterns

### Abstract Factory

**Cuvinte cheie:** familii de obiecte, fabrici abstracte, creare interfețe.
**Scop:** Oferă o interfață pentru crearea familiilor de obiecte înrudite sau dependente fără a specifica clasele concrete.
**Caracteristici:**

- Izolarea concretizărilor clasei.
- Promovează consistența produsului.
- Suport pentru noi tipuri de produse.

### Builder

**Cuvinte cheie:** construcție complexă, construcție pas cu pas, separare reprezentare/creare.
**Scop:** Separă construcția unui obiect complex de reprezentarea sa, astfel încât același proces de construcție să poată crea reprezentări diferite.
**Caracteristici:**

- Permite schimbarea reprezentării interne a produsului.
- Încapsulează codul de asamblare și reprezentarea.

### Factory Method

**Cuvinte cheie:** creare interfețe, instanțiere subclase, delegare creare.
**Scop:** Definește o interfață pentru crearea unui obiect, dar lasă clasele care o implementează să decidă ce clasă să instanțieze.
**Caracteristici:**

- Delegă responsabilitatea de instanțiere clasei derivată.
- Suportă extinderea prin derivare.

### Prototype

**Cuvinte cheie:** clonare, obiecte prototip, evitare subclasare.
**Scop:** Specifică tipurile de obiecte de creat folosind o instanță prototip și creează noi obiecte prin copierea acestui prototip.
**Caracteristici:**

- Adaugă și elimină produse la runtime.
- Definește obiecte noi prin variația valorilor.

### Singleton

**Cuvinte cheie:** instanță unică, acces global, control instanțiere.
**Scop:** Asigură că o clasă are o singură instanță și oferă un punct de acces global la aceasta.
**Caracteristici:**

- Acces controlat la instanță singulară.
- Poate amâna inițializarea instanței.

## Structural Patterns

### Adapter

**Cuvinte cheie:** compatibilitate interfețe, adaptor, învelire interfață.
**Scop:** Convertește interfața unei clase într-o altă interfață așteptată de clienți. Adapterul permite colaborarea claselor care altfel nu ar putea lucra împreună datorită incompatibilității interfețelor.
**Caracteristici:**

- Reutilizează o interfață existentă.
- Traduce cererile între interfețe diferite.

### Bridge

**Cuvinte cheie:** separare abstractizare/implementare, structură extensibilă, "decuplare".
**Scop:** Desparte o abstracție de implementarea sa, astfel încât cele două să poată varia independent.
**Caracteristici:**

- Abstracție și implementare pot varia independent.
- Ascunde detalii de implementare de la client.

### Composite

**Cuvinte cheie:** structură arbore, compoziție obiecte, "obiecte-containere".
**Scop:** Compune obiecte în structuri de arbori pentru a reprezenta ierarhii parte-întreg.
**Caracteristici:**

- Simplifică clienții prin tratarea obiectelor compuse și individuale uniform.
- Facilitează adăugarea de noi tipuri de componente.

### Decorator

**Cuvinte cheie:** adăugare responsabilități, extindere funcționalități, învelire obiecte.
**Scop:** Atașează responsabilități suplimentare unui obiect dinamic.
**Caracteristici:**

- Mai flexibil decât moștenirea statică.
- Permite extinderea funcționalităților unui obiect.

### Facade

**Cuvinte cheie:** interfață simplificată, ascundere complexitate, unificare interfețe.
**Scop:** Oferă o interfață unificată pentru un set de interfețe dintr-un subsistem. Façade definește o interfață de nivel înalt care face subsistemul mai ușor de utilizat.
**Caracteristici:**

- Simplifică interfața subsistemului.
- Reduce dependența de subsistem.

### Flyweight

**Cuvinte cheie:** partajare stări, optimizare memorie, obiecte mici.
**Scop:** Folosește partajarea pentru a suporta eficient un număr mare de obiecte fine.
**Caracteristici:**

- Reduce costul de stocare pentru obiecte mari.
- Gestionează partajarea stării.

### Proxy

**Cuvinte cheie:** control acces, înlocuitor, protecție obiecte.
**Scop:** Oferă un înlocuitor sau un marcator de locație pentru un alt obiect pentru a controla accesul la acesta.
**Caracteristici:**

- Poate controla obiectul real.
- Poate adăuga funcționalități suplimentare.

## Behavioral Patterns

### Chain of Responsibility

**Cuvinte cheie:** lanț handleri, delegare responsabilități, evitare cuplare.
**Scop:** Permite trecerea cererilor de-a lungul unui lanț de handleri. La primirea unei cereri, fiecare handler decide fie să o proceseze, fie să o treacă mai departe în lanț.
**Caracteristici:**

- Reduce cuplarea, deoarece nu este necesar ca emițătorul cererii să cunoască handler-ul specific care va procesa cererea.
- Permite setarea dinamică a lanțului de handleri.
- Promovează principiul responsabilității unice prin separarea handlerilor.

### Command

**Cuvinte cheie:** comandă obiect, decuplare solicitant-executant, "undo".
**Scop:** Transformă o cerere într-un obiect independent, permițând parametrizarea clienților cu diferite cereri, cozi sau logări de cereri și suport pentru operațiuni care pot fi anulate.
**Caracteristici:**

- Separă obiectul care invocă operația de cel care știe cum să o execute.
- Permite stocarea, transmiterea și reexecutarea comenzilor.
- Suportă operațiuni "undo" prin inversarea efectelor unei comenzi anterioare.

### Interpreter

**Cuvinte cheie:** procesare limbaj, gramatică, interpretare arbore.
**Scop:** Definirea unei reprezentări gramaticale pentru un limbaj și un interpretor care folosește această reprezentare pentru a interpreta expresiile în limbaj.
**Caracteristici:**

- Se aplică limbajelor cu o gramatică relativ simplă.
- Interpretorul utilizează o structură arbore pentru a reprezenta structura gramaticală a expresiilor.
- Fiecare regulă din gramatică este reprezentată printr-o clasă.

### Iterator

**Cuvinte cheie:** acces secvențial, navigare colecții, traversare abstractă.
**Scop:** Oferă o modalitate de a accesa elementele unei colecții agregate fără a expune reprezentarea sa subiacentă.
**Caracteristici:**

- Separă navigarea într-o colecție de operațiile pe acea colecție.
- Oferă o interfață standard pentru traversarea diferitelor tipuri de colecții.
- Permite mai multe traversări simultane ale aceleiași colecții.

### Mediator

**Cuvinte cheie:** comunicare centralizată, reducere dependențe, control interacțiuni.
**Scop:** Definește un obiect care încapsulează modul în care un set de obiecte interacționează. Mediatorul promovează cuplarea slabă prin menținerea obiectelor de comunicare fără a se referi explicit unul la altul.
**Caracteristici:**

- Reduce complexitatea comunicațiilor între obiecte multiple.
- Centralizează controlul interacțiunilor între obiecte.
- Ajută la gestionarea dependențelor între obiecte.

### Memento

**Cuvinte cheie:** salvare stare, restaurare stare, "undo".
**Scop:** Permite salvarea și restaurarea stării anterioare a unui obiect fără a dezvălui detaliile implementării sale.
**Caracteristici:**

- Oferă posibilitatea de a restabili starea unui obiect la o stare anterioară (undo).
- Încapsulează starea internă a obiectului, protejând-o de modificările externe.
- Permite un rollback eficient și sigur pentru obiecte complexe.

### Observer

**Cuvinte cheie:** dependență "one-to-many", notificare schimbări, "listeners".
**Scop:** Definește o dependență de tipul "one-to-many" între obiecte astfel încât atunci când un obiect își modifică starea, toate obiectele dependente sunt notificate și actualizate automat.
**Caracteristici:**

- Susține comunicația slab cuplată între obiecte.
- Permite propagarea schimbărilor de stare fără a necesita cunoașterea sau interacțiunea directă între obiecte.
- Suportă configurări dinamice ale observatorilor și subiectului.

### State

**Cuvinte cheie:** schimbare comportament, stări obiect, tranziții stări.
**Scop:** Permite unui obiect să-și schimbe comportamentul atunci când starea sa internă se schimbă, apărând ca și cum și-ar schimba clasa.
**Caracteristici:**

- Încapsulează comportamentele specifice stării în clase separate.
- Reduce complexitatea condițiilor bazate pe stări în clasele context.
- Permite schimbări ușoare și adăugiri de noi stări.

### Strategy

**Cuvinte cheie:** selecție algoritmi, comportament dinamic, "politici".
**Scop:** Definește o familie de algoritmi, îi încapsulează și îi face interschimbabili. Strategia permite ca algoritmul să varieze independent de clienții care îl folosesc.
**Caracteristici:**

- Oferă o modalitate de a configura o clasă cu unul dintre mai mulți comportamente.
- Permite schimbarea comportamentului la rulare.
- Reduce ramificațiile condiționale bazate pe comportamente diferite.

### Template Method

**Cuvinte cheie:** schelet algoritm, redefinire pași, "hooks".
**Scop:** Definește scheletul unui algoritm într-o metodă operație, amânând unele pași la subclase. Template Method permite redefinirea anumitor pași ai unui algoritm fără a schimba structura acestuia.
**Caracteristici:**

- Oferă o structură de bază pentru un algoritm, cu posibilitatea de extindere.
- Promovează reutilizarea codului.
- Permite subclaselor să ofere implementări concrete pentru pașii algoritmului.

### Visitor

**Cuvinte cheie:** operații obiecte, separare operații, adăugare funcționalități.
**Scop:** Permite definirea unei noi operații fără a schimba clasele elementelor pe care operează.
**Caracteristici:**

- Separă un algoritm de obiectele pe care le operează.
- Adaugă noi operații la o structură obiectuală fără a modifica structura.
- Permite operații complexe peste structuri obiectuale diferite.
