# trabajoLinea

//Declaracion de la vista desde el pgAdmin
CREATE VIEW v_autor 
AS
SELECT *
	FROM public.autor as a
		 JOIN public.libro AS l
		 ON l.id_autor = a.id