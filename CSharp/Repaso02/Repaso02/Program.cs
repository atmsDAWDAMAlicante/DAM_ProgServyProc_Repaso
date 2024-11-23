using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repaso02
	{
	internal class Program
		{
		static void Main2(string[] args)
			{
			Console.WriteLine("Vamos a hacer una espera de 3 segundos");
			Task.Delay(1000).Wait();// crea una tarea asíncrona que esperará 1 segundo
									// pero la ejecución del hilo principal continúa
			// para que se produzca la espera hay q ue añadir una llamada .wait
			// El método delay devuelve unun objeto Tarea Task que también tiene un método wait
			// Wait espera a que se complete la ejecución del objeto Task
			// No ejecutará otra tarea hasta que finalice la Task (que es Delay)
			
			
			Console.WriteLine("Espe");
			Console.ReadKey();
			}
		}
	}
