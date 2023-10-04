@FunctionalInterface
public interface Autenticador {
//    default boolean autentica (String senha) {
//        if (this.senha != senha) {
//            System.out.println("Não autenticado!");
//            return false;
//        }else{
//            System.out.println("Autenticado");
//            return true;
//        }
//    }

    public abstract boolean autentica(String senha);
}
