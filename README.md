# Team Project

Please keep this up-to-date with information about your project throughout the term.

The readme should include information such as:
- a summary of what your application is all about
- a list of the user stories, along with who is responsible for each one
- information about the API(s) that your project uses 
- screenshots or animations demonstrating current functionality

By keeping this README up-to-date,
your team will find it easier to prepare for the final presentation
at the end of the term.

# Project Name: TikZ-Maker
# Summary:
A graphical desktop application that allows users to create mathematical and geometric diagrams through an interactive interface, preview them in real time, and export the corresponding LaTeX (TikZ) code.

## Team Information
### Team Members
- Arad Fathalian
- Helia Javidrad
- Jiayi Sun
- Zihan Wang
---

## Project Description
### Domain
Productivity app. TikZ is a cumbersome package for users new and experienced with LaTeX,
and so the goal is to provide a GUI for creating diagram elements in a 2D environment.
The diagram can be previewed upon changes being made, and the diagram can be exported
into a TikZ code block the user can insert straight into their LaTeX document.
Alternatively, through use of the Overleaf API, users can push their diagrams straight
to a document on Overleaf.
---

## User Stories
### User Story 1: 
As a user, I want a simple graphical way to create and describe various shapes so that my descriptions
will be added to the TikZ code.

### User Story 2:
As a user, I want a real-time preview of my changes so that I can see if I need to make
changes to my diagram.

### User Story 3:
As a user, I want to be able to edit and delete objects I have added to my diagram,
and I want to be able to edit their attributes.

(I.E. fine-grained colour changes, thickness changes, line-dashing, arrow heads, etc.)

### User Story 4:
As a user, I want to be able to save my work to a stand-alone `.tex` diagram file,
to the clipboard for easy insertion into a pre-existing `.tex` document, or to
an Overleaf project.

### User Story 5 (If Enough Time):
As a user, I want to easily be able to insert the graph of provided simple functions
into my diagram (I.E. `y=cos(x)`.) I want to be able to specify the generated domain,
range, attributes (as above,) and sample-rate (I.E. "sharpness.")
---

## Use Cases
Note that since this is a simple utility program with only a single user at a time,
the "Primary Actor" field isn't included below.

### Use Case 1 (Creation of Diagram Elements)
**Use Case:** Creation of a diagram element (I.E. Circle, Square, line, etc.)

**Preconditions:**
- The user is not concurrently creating/editing another element.

**Trigger:** The user clicks the "New" button in the Elements tab.

**Success Outcome:** The user specifies a shape type, the relevant coordinates, the
attributes of the element, and a matching object instance gets created and stored.

**Main Success Scenario:**
1. The user clicks the "New" button in the Elements tab
2. A new window opens prompting the user about the details of their desired element
3. The system checks that the input values are valid (I.E. Radii cannot be non-positive)
4. The element is added and shown in the "Elements" tab

**Extensions:**
- 1a. The user is already editing another diagram element
  1. The "New" button is greyed out and clicking it at this time does nothing
  2. The "New" button becomes accessible again upon the user finishing what they're doing
- 3a. The user inputs an invalid value
  1. The invalid value is caught and an error window is opened informing the user
  2. Control is handed back upon dismissal of the error window to correct the value

### Use Case 2 (Updating TikZ Code and Preview On Changes)
**Use Case:** Upon creating or editing a diagram element, the TikZ code gets
accordingly updated and a new preview diagram gets generated.

**Preconditions:**
- A change has successfully occurred with an Element object in the diagram
- The specific changed element index has been provided (need to implement some sort of
storage system for this)

**Trigger:** A change has occurred with an Element object in the list.

**Success Outcome:** The triggered change is reflected in the TikZ code, and the preview
of the TikZ code output is re-generated accordingly.

**Main Success Scenario:**
1. The User creates a new Element or Edits a pre-existing one
2. The respective class instance is created or edited to reflect this change
3. The change is passed to the Interactor responsible for altering the TikZ code
4. After the TikZ code has been updated, the `pdflatex` command is ran to re-generate
the diagram

### Use Case 3 (Edit or Deletion of an Element)
**Use Case:** The user decides to edit or delete a pre-existing element.

**Preconditions:**
- The user has already created >=1 element
- The user has specified which element is to be edited or deleted
- The user has made valid changes to the relevant attributes (if editing)

---
## Minimal Viable Product (MVP)
| Team Member | MVP Use Case |
|-------------|--------------|
| Arad Fathalian | Use Case 1 or 2 |
| Helia Javidrad | Use Case 3 |
| Jiayi Sun | Use Case 4 |
| Zihan Wang | Use Case 2 or 1 |
---
## Entities

### Entity 1

### Entity 2
(Add additional entities as needed.)
---
## API Usage
**API Name:**
**Documentation:** [Link]
**How it is used in the program:**
---
## Design Diagrams
### UML Class Diagram
### Sequence Diagrams
---
## How to Run
[Instructions for running the program.]
---
## Notes
[Any additional project information]