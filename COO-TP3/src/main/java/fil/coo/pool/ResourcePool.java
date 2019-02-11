package fil.coo.pool;


import java.util.*;




import fil.coo.resource.Resource;

/**
 * @author pelage
 *
 * @param <T>
 * a ResourcePool class
 */
public abstract class ResourcePool <T extends Resource>  {
	protected int size ; 
	protected List <T>  available ;
	protected List <T> occupied ;
	
	/**
	 * create a resourcepool
	 * @param size
	 */
	public ResourcePool(int size){
		this.size=size;
		this.available=new ArrayList<T>();
		this.occupied=new ArrayList<T>();
		for (int i=0;i<this.size;i++){
			this.available.add(this.CreateResource());
		}
		
	}

	/**
	 * @return the element removed from available list
	 * @throws NoSuchElementException
	 */
	public T ProvideResource()throws NoSuchElementException{
		if (available.isEmpty()){
			throw new NoSuchElementException();
		}
		else {
			
			T inter=available.remove(0);
			occupied.add(inter);
			return inter;	 	
		}

	};
	/**
	 * 
	 * @param resource 
	 * @throws IllegalArgumentException
	 */
	public void RecoverSource(T resource)throws IllegalArgumentException{
		if (this.occupied.contains(resource)){
			this.occupied.remove(resource);
			this.available.add(resource);
		 }
		 else {
			 throw new IllegalArgumentException();	 	
		 }	

	};
	/**
	 * @return true if occupied list is empty
	 */
	public boolean occupiedIsEmpty(){
		return occupied.isEmpty();
	};
	/**
	 * @return true if available list is empty
	 */
	public boolean availableIsEmpty(){
		return available.isEmpty();
	};
	
	public List<T> getavailable(){
		return this.available;
	}
	public List<T> getoccupied(){
			return this.occupied;
		}

	
	protected abstract T CreateResource();
}