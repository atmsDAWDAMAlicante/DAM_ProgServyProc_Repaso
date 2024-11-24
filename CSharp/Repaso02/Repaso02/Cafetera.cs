using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso02
	{
	class Cafetera
		{
		public static int espera = 2000;
		static async Task Main3(string[] args) // await se ejecuta dentro de un método async EL MAIN
			{
			// PARA HACER UN AWAIT EL MÉTODO TIENE QUE DEVOLVER UN TASK
			Task tCafe = PrepararCafe();
			Task tTostadas = PrepararTostada();
			await tCafe; // await funciona con tareas Task se ejecutan los dos métodos asíncronamente
			await tTostadas; // se le dice al hilo principal que espere a que finalicen las dos
			Console.WriteLine("Desayuno finalizado"); // finalizadas las dos tareas se muestra el mensaje final
			Console.ReadKey();
			}
		static async Task PrepararCafe()
			{
			Console.Write("CAFETERA: Preparando el Café");
			Console.WriteLine("Cafetera: se acerca al fuego");
			await Task.Delay(espera);
			//Task.Delay(espera).Wait();
			Console.WriteLine("Cafetera: sale el café");
			await Task.Delay(espera);
			//Task.Delay(espera).Wait();
			Console.WriteLine("Cafetera: se echa en la taza");
			await Task.Delay(espera);
			//Task.Delay(espera).Wait();
			Console.WriteLine("Cafetera: se pone azucar");
			await Task.Delay(espera);
			//Task.Delay(espera).Wait();
			Console.WriteLine("Cafetera: FINALIZADO");

			}

		static async Task PrepararTostada()
			{
			Console.Write("TOSTADORA: Preparando las tostadas");
			Console.WriteLine("Tostadora: Se corta el pan");
			await Task.Delay(espera);
			Console.WriteLine("Tostadora: Se acerca el pan al fuego");
			await Task.Delay(espera);
			Console.WriteLine("Tostadora: Se pone la tostada en el plato");
			await Task.Delay(espera);
			Console.WriteLine("Tostadora: Se le echa aceite al pan");
			await Task.Delay(espera);
			Console.WriteLine("Tostadora: FINALIZADO");
			}
		}
	}
